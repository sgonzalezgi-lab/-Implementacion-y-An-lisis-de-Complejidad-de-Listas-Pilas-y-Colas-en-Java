import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker


try:
    df = pd.read_csv('resultados1.csv')
except FileNotFoundError:
    print("Error: No se encontró 'resultados1.csv'.")



def generar_graficas_con_comas(df):

    df['avg_time_us'] = df['avg_time_ns']

    implementaciones = [
        "SinglyLinkedListNoTail", 
        "SinglyLinkedListTail",
        "DoublyLinkedListNoTail", 
        "DoublyLinkedListTail",
        "Queue",
        "Stack"
    ]

    plt.style.use('ggplot')

    formateador_comas = ticker.FuncFormatter(lambda x, p: format(int(x), ','))

    for impl in implementaciones:
        subset = df[df['implementation'] == impl]
        if subset.empty: continue

        plt.figure(figsize=(11, 7))
        
        for oper, group in subset.groupby('operation'):
            plt.plot(group['size'], group['avg_time_us'], 
                     marker='o', markersize=5, label=oper, linewidth=2)

        ax = plt.gca()
        plt.xlabel('Tamaño de entrada (N)')
        plt.ylabel('Tiempo de ejecución promedio (ns)')
        
        
        ax.set_xscale('log')
        ax.xaxis.set_major_formatter(formateador_comas)
        
        ticks_x = sorted(subset['size'].unique())
        ax.set_xticks(ticks_x)
        ax.set_xticklabels([format(int(x), ',') for x in ticks_x])

        
        ax.set_yscale('log')
        ax.yaxis.set_major_formatter(formateador_comas)

        # Estética
        plt.grid(True, which="major", linestyle='-', alpha=0.6, color='white')
        plt.grid(True, which="major", linestyle='-', alpha=0.7, color='white')
        plt.grid(True, which="minor", linestyle=':', alpha=0.4, color='white')
        
        plt.legend(loc='upper left', frameon=True, shadow=True)
        
        plt.figtext(0.5, 0.01, f"Resultados de rendimiento para {impl}", ha="center", fontsize=10, 
            bbox={"facecolor":"green", "alpha":0.05, "pad":5})
        
        plt.tight_layout(rect=[0, 0.05, 1, 1])

    plt.show()

if 'df' in locals():
    generar_graficas_con_comas(df)