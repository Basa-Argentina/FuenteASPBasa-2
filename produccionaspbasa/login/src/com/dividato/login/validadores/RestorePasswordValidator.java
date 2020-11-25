package com.dividato.login.validadores;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;

import com.security.modelo.seguridad.User;
import com.security.recursos.ValidacionEMail;
/**
 * 
 * @author Gabriel Mainero
 * @modified Ezequiel Beccaria
 *
 */
@Component
public class RestorePasswordValidator implements Validator {
	
	/**
	 * Indica cual es la clase que este validador puede validar.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class type) {
		return User.class.isAssignableFrom(type);
	}

	/**
	 * Inicializa el WebDataBinder con los campos requeridos y las conversiones de tipos de datos.
	 * @param binder
	 */
	public void initDataBinder(WebDataBinder binder) {
		binder.setRequiredFields(new String[] {"persona.mail"});
	}
	/**
	 * Valida los valores de las propiedades del objeto.
	 */
	@Override
	public void validate(Object command, Errors errors) {
		//aqu� ir�an validaciones sobre los valores del objeto.
		//de los campos requeridos y las conversiones se encarga el WebDataBinder 
		User user = (User) command;
		if(user.getPersona().getMail()!=null && !"".equals(user.getPersona().getMail())){
			if(!ValidacionEMail.validar(user.getPersona().getMail())){
				errors.rejectValue("persona.mail", "formularioRestorePassword.errorFormatoEMail");
			}	
		}
	}		
}