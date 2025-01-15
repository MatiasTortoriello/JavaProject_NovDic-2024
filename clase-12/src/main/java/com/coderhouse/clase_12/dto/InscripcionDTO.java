package com.coderhouse.clase_12.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InscripcionDTO {
    private Long alumnoId;
    private List<Long> cursosId;
	public Long getAlumnoId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long[] getCursosId() {
		// TODO Auto-generated method stub
		return null;
	}
}
