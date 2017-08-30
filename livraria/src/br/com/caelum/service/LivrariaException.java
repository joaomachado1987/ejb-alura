package br.com.caelum.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends Exception {

}
