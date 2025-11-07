package com.medpro.medpro.model.DTO;

import com.medpro.medpro.enums.Especialidade;
import com.medpro.medpro.model.entity.Medico;

public record DadosListagemMedicos(String nome, String crm, Especialidade especialidade) {
    public DadosListagemMedicos(Medico medico){
        this.
    }
}
