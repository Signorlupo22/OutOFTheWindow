package classifica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class VetClassifica extends Classifica implements Serializable {

	private Classifica v[];

	public VetClassifica(int n) {
		v = new Classifica[n];
		for (int i = 0; i < n; i++)
			v[i] = new Classifica();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VetClassifica other = (VetClassifica) obj;
		return Arrays.equals(v, other.v);
	}

	public Classifica getC(int i) {
		return v[i];
	}

	public Classifica[] getV() {
		return v;
	}

	public void setV(Classifica[] v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "VetClassifica [v=" + Arrays.toString(v) + "]";
	}

	public void save(String file) {
		try {
			ObjectOutputStream fo = new ObjectOutputStream(new FileOutputStream(file));
			fo.writeObject(this);
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static VetClassifica load(String file) {
		try {
			ObjectInputStream fo = new ObjectInputStream(new FileInputStream(file));
			VetClassifica v = (VetClassifica) fo.readObject();
			fo.close();
			return v;
		} catch (FileNotFoundException e1) {
			VetClassifica v = new VetClassifica(3);
			v.save("classifiche.bin");
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
