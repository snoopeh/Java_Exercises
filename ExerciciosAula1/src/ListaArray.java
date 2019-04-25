
public class ListaArray<E> {

	public Object[] list = new Object[0];

	public boolean add(E it) {
		increaseList();
		list[list.length - 1] = it;
		return true;
	}

	public boolean add(E it, int pos) {
		list[pos] = it;
		return true;
	}

	public E remove(int pos) {
		Object ret = list[pos];
		list[pos] = null;
		decreaseList(pos);
		return (E) ret;
	}

	public E get(int pos) {
		return (E) list[pos];
	}

	private void decreaseList(int pos) {
		Object[] a = new Object[list.length-1];
		for (int i = 0; i < list.length; i++) {
			if(i<pos) {
				a[i] = list[i];
			}
			if(i>pos) {
				a[i-1] = list[i];
			}
		}
		list = a;
	}

	private void increaseList() {
		Object[] listaAux = new Object[list.length + 1];
		for (int i = 0; i < listaAux.length - 1; i++) {
			listaAux[i] = list[i];
		}
		list = listaAux;
	}

	public int size() {
		return list.length;
	}

}
