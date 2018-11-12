/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipol.sample.service;

import it.unipol.sample.model.Email;
import java.util.List;

/**
 *
 * @author matt.rossi
 */
public interface EmailService {

    Email getEmail();

    List<Email> getAllEmail();

    Email saveEmail(Email email);

    void deleteEmailById(Long id);

    Email updateEmail(Email email);

}
