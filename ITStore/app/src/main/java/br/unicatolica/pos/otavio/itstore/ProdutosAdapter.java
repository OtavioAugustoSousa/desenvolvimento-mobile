package br.unicatolica.pos.otavio.itstore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.unicatolica.pos.otavio.itstore.model.Produto;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolderProdutos> {

    private final List<Produto> dados;
    private final OnItemClick onClickListener;

    public ProdutosAdapter(List<Produto> dados, OnItemClick onClickListener) {
        this.dados = dados;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ProdutosAdapter.ViewHolderProdutos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha,parent,false);
        ViewHolderProdutos holderProdutos = new ViewHolderProdutos(view);
        return holderProdutos;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosAdapter.ViewHolderProdutos holder, int position) {
        if(dados == null || dados.size()  == 0 ){
            return;
        }
        final Produto produto = dados.get(position);
        holder.txtNome.setText(produto.getNome());
        holder.txtPreco.setText(produto.getPreco());
        holder.itemView.findViewById(R.id.cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(produto);
            }
        });
        holder.itemView.setLongClickable(true);
        holder.itemView.findViewById(R.id.cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(produto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    protected class ViewHolderProdutos extends RecyclerView.ViewHolder{
        public TextView txtNome;;
        public TextView txtPreco;
        public ViewHolderProdutos(View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPreco = itemView.findViewById(R.id.txtPreco  );

        }
    }
     interface  OnItemClick{
        void onClick(Produto produto);
        void onLongClick(Produto produto);
     }
}