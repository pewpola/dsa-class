package entities;

public class ArrayList<E> extends StaticList<E> {
    @SuppressWarnings("unchecked")
    public ArrayList(){
        staticList = (E[]) new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    private void recreateStaticList(){
      
        E[] newStaticList = (E[])new Object[(staticList.length*3)/2+1];
        for(int i = 0; i < size; i++){
            newStaticList[i] = staticList[i];
        }
        staticList = newStaticList;
    }

    @Override
    public void add(E value) {
        if(size == staticList.length){
            recreateStaticList();
        }

        staticList[size] = value;
        size++;   
    }

    @Override
    public void insert(E value) {        
        super.insert(value);
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {        
        super.insert(index, value);
    }


    
}
