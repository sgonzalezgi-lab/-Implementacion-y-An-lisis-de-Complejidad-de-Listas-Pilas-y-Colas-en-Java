import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker


try:
    df = pd.read_csv('resultados1.csv')
    df['operation'] = df['operation'].str.strip().str.lower()
    df['implementation'] = df['implementation'].str.strip()
except FileNotFoundError:
    print("Error: No se encontró 'resultados1.csv'.")

def graficar_primeras_comparativas(df):
    plt.style.use('ggplot')
    formateador = ticker.FuncFormatter(lambda x, p: format(int(x), ','))
    
    comparativas = [
        (
            "Comparativa: Inserción al Inicio (PushFront vs Push)",
            [("SinglyLL NoTail: pushfront", "SinglyLinkedListNoTail", "pushfront"),
             ("Stack: push", "Stack", "push")],
            "Ambas son O(1). SinglyLL es la opción más eficiente al no requerir puntero Tail."
        ),
        (
            "Comparativa: Inserción al Final (PushBack vs Enqueue)",
            [("SinglyLL Tail: pushback", "SinglyLinkedListTail", "pushback"),
             ("Queue: enqueue", "Queue", "enqueue")],
            "Se usa SinglyLL con Tail para igualar el O(1) de la Queue (Circular Array)."
        )
    ]

    for titulo, queries, justificacion in comparativas:
        plt.figure(figsize=(10, 6))
        
        for label, impl, oper in queries:
            subset = df[(df['implementation'] == impl) & (df['operation'] == oper)]
            if not subset.empty:
                plt.plot(subset['size'], subset['avg_time_ns'], marker='o', label=label, linewidth=2)

        ax = plt.gca()
        plt.xlabel('Tamaño de entrada (N)')
        plt.ylabel('Tiempo de ejecución promedio (ns)')
        ax.set_xscale('log')
        ax.set_yscale('log')
        
        ticks_x = sorted(subset['size'].unique())
        ax.set_xticks(ticks_x)
        ax.xaxis.set_major_formatter(formateador)

        
        subs_y = [1.0, 2.0, 5.0] 
        
        ax.yaxis.set_major_locator(ticker.LogLocator(base=10.0, subs=subs_y, numticks=12))
        ax.yaxis.set_major_formatter(formateador)
        
        ax.yaxis.set_minor_locator(ticker.LogLocator(base=10.0, subs='auto', numticks=12))
        ax.yaxis.set_minor_formatter(ticker.NullFormatter())

        plt.grid(True, which="major", linestyle='-', alpha=0.7, color='white')
        plt.grid(True, which="minor", linestyle=':', alpha=0.4, color='white')
        
        plt.legend(loc='upper left', frameon=True, shadow=True)
        
        plt.figtext(0.5, 0.01, justificacion, ha="center", fontsize=10, 
                    bbox={"facecolor":"green", "alpha":0.05, "pad":5})
        
        plt.tight_layout(rect=[0, 0.05, 1, 1])

    plt.show()

if 'df' in locals():
    graficar_primeras_comparativas(df)