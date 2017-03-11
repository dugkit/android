package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import model.Usuario;

public class UserAdapter extends ArrayAdapter<Usuario>{

    private LayoutInflater mInflater;
    private List<Usuario> listaItens;

    public UserAdapter(Context context, int resource,
                           List<Usuario> itensDaLista) {
        super(context, resource, itensDaLista);
        mInflater = LayoutInflater.from(context);
        listaItens = itensDaLista;
    }

    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        View formatoItemLista = mInflater.inflate(R.layout.layout_lista_produto,
                null);

        Usuario p = listaItens.get(position);

        TextView txtProductName = (TextView) formatoItemLista.findViewById(R.id.txtProductName);
        txtProductName.setText(p.getNome());

        TextView txtProductCategory = (TextView) formatoItemLista.findViewById(R.id.txtProductCategory);
        txtProductCategory.setText(p.getEmail());

        TextView txtProductPrice = (TextView) formatoItemLista.findViewById(R.id.txtProductPrice);
        DecimalFormat fmt = new DecimalFormat("R$ #,##0.00");
        txtProductPrice.setText(fmt.format(p.getSenha()));

        return formatoItemLista;
    }
}
