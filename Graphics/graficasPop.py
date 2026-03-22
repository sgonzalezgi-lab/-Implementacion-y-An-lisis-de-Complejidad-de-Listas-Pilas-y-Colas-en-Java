import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker


try:
    df = pd.read_csv('resultados1.csv')
    df['operation'] = df['operation'].str.strip().str.lower()
    df['implementation'] = df['implementation'].str.strip()
except FileNotFoundError:
    print("Error: No se encontró 'resultados1.csv'.")

def graficar_con_resolucion_logaritmica(df):
    plt.style.use('ggplot')
    formateador = ticker.FuncFormatter(lambda x, p: format(int(x), ','))
    
    comparativas = [
        (
            "Comparativa: Eliminación al Inicio (PopFront vs Dequeue)",
            [("SinglyLL Tail: popfront", "SinglyLinkedListTail", "popfront"),
             ("Queue: dequeue", "Queue", "dequeue")],
            "Ambas son O(1). SinglyLL es óptima para extraer el primer elemento"
        ),
        (
            "Comparativa: Eliminación al Final (PopBack vs Pop)",
            [("DoublyLL Tail: popback", "DoublyLinkedListTail", "popback"),
             ("Stack: pop", "Stack", "pop")],
            "Se usó DoublyLinkedListTail porque es la única lista con O(1) real al eliminar el último nodo."
        )
    ]

    for titulo, queries, justificacion in comparativas:
        plt.figure(figsize=(11, 7))
        plt.xlabel('Tamaño de entrada (N)')
        plt.ylabel('Tiempo de ejecución promedio (ns)')
        
        for label, impl, oper in queries:
            subset = df[(df['implementation'] == impl) & (df['operation'] == oper)]
            if not subset.empty:
                plt.plot(subset['size'], subset['avg_time_ns'], marker='o', label=label, linewidth=2.5, markersize=7)

        ax = plt.gca()
        
        ax.set_xscale('log')
        ticks_x = sorted(subset['size'].unique())
        ax.set_xticks(ticks_x)
        ax.xaxis.set_major_formatter(formateador)

        ax.set_yscale('log')
        
        subs = [1.0, 2.0, 5.0]
        
        ax.yaxis.set_major_locator(ticker.LogLocator(base=10.0, subs=subs, numticks=12))
        
        ax.yaxis.set_major_formatter(formateador)
        
    
        ax.yaxis.set_minor_locator(ticker.LogLocator(base=10.0, subs='auto', numticks=12))
        ax.yaxis.set_minor_formatter(ticker.NullFormatter())

        # Estética
        plt.grid(True, which="major", linestyle='-', alpha=0.6, color='white')
        plt.grid(True, which="major", linestyle='-', alpha=0.7, color='white')
        plt.grid(True, which="minor", linestyle=':', alpha=0.4, color='white')
        
        plt.legend(loc='upper left', frameon=True, shadow=True)
        
        plt.figtext(0.5, 0.01, justificacion, ha="center", fontsize=10, 
                    bbox={"facecolor":"green", "alpha":0.05, "pad":5})
        
        plt.tight_layout(rect=[0, 0.05, 1, 1])

    plt.show()

if 'df' in locals():
    graficar_con_resolucion_logaritmica(df)