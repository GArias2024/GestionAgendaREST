package com.contact.manag.agenda.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetContactosResponseDto {

    @JsonProperty("contactos")
    List<ContactoResponseDto> listContactos;

    @JsonProperty("total de contactos")
    long total;

    @JsonProperty("paginas")
    int pag;

    @JsonProperty("elementos por pagina")
    int elemPag;

    @JsonProperty("pagina actual")
    int pagActu;

    public List<ContactoResponseDto> getListContactos() {
        return listContactos;
    }

    public void setListContactos(List<ContactoResponseDto> listContactos) {
        this.listContactos = listContactos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public int getElemPag() {
        return elemPag;
    }

    public void setElemPag(int elemPag) {
        this.elemPag = elemPag;
    }

    public int getPagActu() {
        return pagActu;
    }

    public void setPagActu(int pagActu) {
        this.pagActu = pagActu;
    }

}
