package com.daca.listapramim.api.compra;

import com.daca.listapramim.api.compra.Compra;
import com.daca.listapramim.api.compra.CompraRepository;
import com.daca.listapramim.api.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class CompraService  extends GenericService<Long, Compra, CompraRepository> {

    @Autowired
    private  CompraRepository compraRepository;

    public void create(Compra compra){
        try {
            this.compraRepository.save(compra);
        }catch (ConstraintViolationException
                e){
            throw new RuntimeException("Lista já existente"+ e.getMessage());
        }
    }

    @ReadOnlyProperty
    public Compra show(Long id){
        if(!this.compraRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma compra");
        }
        try{
            Compra compra = this.compraRepository.findById(id).orElseThrow(RuntimeException::new);
            return compra;
        }catch (IllegalArgumentException iae){
            throw new RuntimeException("");
        }
    }

    public Compra update(Long id, Compra compra){
        if(!this.compraRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma lista");
        }
        compra.setId(id);
        return this.compraRepository.save(compra);
    }

    public void delete(Long id){
        if(!this.compraRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma lista");
        }
        this.compraRepository.deleteById(id);
    }


    public List<Compra> getByItemId(Long id){
        return this.compraRepository.getAllByItem_Id(id);
    }


}
