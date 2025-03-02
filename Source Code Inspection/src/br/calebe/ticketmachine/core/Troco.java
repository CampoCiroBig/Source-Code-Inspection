/*
Ciro Campos de Carvalho - 10418360
*/
package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    /*
    Defeito de Estrutura de Dados - a Array está sendo sobreescrito de forma errada

    */
    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
         /*
        Defeito de inicialização - o PapelMoeda[6] não possui valor 
        */
        papeisMoeda = new PapelMoeda[6]
        int count = 0;
        /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
         /*
        Defeito de dados - count sempre é zerado 
        */
        count = 0;
         /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
         /*
        Defeito de dados - count sempre é zerado 
        */
        count = 0;
         /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
         /*
        Defeito de dados - count sempre é zerado 
        */
        count = 0;
         /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
         /*
        Defeito de dados - count sempre é zerado 
        */
        count = 0;
         /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        /*
        Defeito de dados - count sempre é zerado 
        */
        count = 0;
         /*
        Defeito de desempenho - While desnecessário
        */
        while (valor % 2 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
