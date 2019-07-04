package macierze;

import java.util.Iterator;

public class Matrix <T extends Object> implements Iterable{

    private int w;
    private int h;
    private Node<T> First;
    private Addable<T> adder;

    public Matrix(Addable<T> A){
        this.adder=A;
        First = null;
    }

    public void setNode(int w, int h, T val)throws ArrayIndexOutOfBoundsException{
        IteratorMatrix i = this.setIteratorAt(w, h);
        i.set(val); //???
    }
    public void setH(int H){
        this.h = H;
    }
    public void setW(int W) {
        this.w = W;
    }

    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }
    public T getNode (int w, int h)throws ArrayIndexOutOfBoundsException{
        IteratorMatrix i = this.setIteratorAt(w, h);
        return i.get(); //???
    }


    private Matrix.IteratorMatrix setIteratorAt(int w, int h) throws ArrayIndexOutOfBoundsException{
        if(this.h < h || this.w < w){
            throw new ArrayIndexOutOfBoundsException();
        }
        IteratorMatrix i = this.iterator();
        int j=0;
        while(j<(w*h)){
            j++;
            iterator().next();
        }
        return i;
    }
    public void buildMatrix(T[][] tab){
        this.w=tab.length;
        this.h=tab[0].length;
        IteratorMatrix iter = this.iterator();
        for (T[] ts : tab) {
            for (int j = 0; j < tab[0].length; j++) {
                iter.pushLast(ts[j]);
            }
        }
    }

    public Matrix<T> addElements(Matrix<T> m2){
        if(this.getH()!=m2.getH()){
            throw new Error();
        }
        if(this.getW()!=m2.getW()){
            throw new Error();
        }
        Matrix<T> returnVale = new Matrix<T>(adder);
        returnVale.setH(m2.getH());
        returnVale.setW(m2.getW());
        IteratorMatrix i=this.iterator();
        IteratorMatrix j=m2.iterator();
        IteratorMatrix k=returnVale.iterator();
        while(i.hasNext()){
            k.pushLast(this.adder.add(i.get(), j.get()));
            i.next();
            j.next();
            //k.next();
        }
        k.pushLast(this.adder.add(i.get(), j.get()));
        return returnVale;
    }


    @Override
    public String toString(){
        StringBuilder returnVale = new StringBuilder();
        IteratorMatrix iter = this.iterator();
        for(int i=0; i<w;i++){
            for(int j=0; j<h;j++){
                //System.out.println(iter.get().toString()+"--");
                returnVale.append(iter.get().toString()).append("\t");
                iter.next();
            }
            returnVale.append("\n");
        }
        return returnVale.toString();
    }
    @Override
    public IteratorMatrix iterator() {
        return new IteratorMatrix(First);
    }

    public class IteratorMatrix implements Iterator<T>{
        private Node<T> tmp;


        IteratorMatrix(Node<T> F){
            tmp=F;
        }
        @Override
        public boolean hasNext(){

            return tmp.getNextElement() != null;
        }
        @Override
        public T next() {
            T returnVale = tmp.getElements();
            tmp = tmp.getNextElement();
            return returnVale;
        }
        @Override
        public void remove(){

        }

        void pushLast(T val){
            if(tmp==null){
                tmp = new Node<T>(val, null);
                First = tmp;
                return;
            }
            while(this.hasNext())
            {
                this.next();
            }
            tmp.setNextElement(val);
        }
        void set(T val){
            tmp.setElement(val);
        }
        public T get(){
            return tmp.getElements();
        }
    }


}
