package com.example.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Agent;
import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.EmailDetails;
import com.example.demo.entities.Employee;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.EmployeeRepository;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class EmployeeService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private ChefDepartementRepository chefDepartementRepository; 
    
    @Autowired
    private AgentRepository agentRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmailService emailService;
    
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64enocder = Base64.getUrlEncoder();
    
    private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64enocder.encodeToString(token);

    }
    
    public boolean isExist(Employee employee)
    {
    	Admin existingAdmin = adminRepository.findById(employee.getLogin()).orElse(null);
    	if(existingAdmin == null)
    		return false;
    	return true;
    }
    
    public Employee login(Employee employee) {
        Employee existingEmp = employeeRepository.findById(employee.getLogin()).orElse(null);

        if(existingEmp.getLogin().equals(employee.getLogin()) &&
        		existingEmp.getPassword().equals(employee.getPassword()) && 
        		existingEmp.getRole().equals(employee.getRole())) {
        	existingEmp.setPassword("");
            return existingEmp;
        }
        return null;
    }
    
    public EmailDetails createEmail(Employee employee)
    {
    	String messageBody = "Cher(e) " + employee.getFirstname() + ",\n\n" +
    		    "Nous sommes ravis de vous accueillir sur Enicar notes. Voici les informations de connexion à votre compte :\n\n" +
    		    "- Nom d'utilisateur :" + employee.getLogin() + "\n" +
    		    "- Mot de passe :" + employee.getPassword() + "\n" +
    		    "- Role : "+employee.getRole()+"\n\n"+
    		    "Veuillez conserver ces informations en lieu sûr et ne les partager avec personne. Si vous avez des questions ou des préoccupations, n'hésitez pas à nous contacter à l'adresse dhaouadi.hazem567@gmail.com.\n\n" +
    		    "Nous vous recommandons également de prendre quelques instants pour vérifier et mettre à jour vos informations de sécurité, notamment en activant l'authentification à deux facteurs si ce n'est pas déjà fait.\n\n" +
    		    "Merci de votre confiance et de votre soutien à Enicar notes !\n\n" +
    		    "Cordialement,\n" +
    		    "[L'équipe de Enicar notes]";
    	EmailDetails email = new EmailDetails();
    	email.setRecipient(employee.getEmail());
    	email.setSubject("Informations de connexion à Enicar notes");
    	email.setMsgBody(messageBody);
    	return email;
    }
    
    // Traitements pour Admin   
    
    public Admin addAdmin(Admin admin)
    {
    	if(isExist(admin))
    		return null;
    	admin.setRole("Admin");
    	admin.setToken(generateToken());
    	emailService.sendSimpleMail(createEmail(admin));
    	return adminRepository.save(admin);
    }
    
    public Admin getAdminById(String id)
    {
    	return adminRepository.findById(id).orElse(null);
    }
    
    public Admin updateAdmin(Admin admin)
    {
    	Admin existingADM = adminRepository.findById(admin.getLogin()).orElse(null);
        System.out.println(admin);
        if(existingADM == null) {
            System.out.println("Emp not found");
            return  adminRepository.save(admin);
        }else  {
        	existingADM.setFirstname(admin.getFirstname());
        	existingADM.setLastname(admin.getLastname());
        	existingADM.setEmail(admin.getEmail());
        	existingADM.setLogin(admin.getLogin());
        	existingADM.setPassword(admin.getPassword());
        	adminRepository.save(existingADM);
        }
        return admin;
    }
    
    public boolean deleteAdminByID(String id) {
        Admin existingEMP = adminRepository.findById(id).orElse(null);
        if(existingEMP != null) {
        	adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Admin> getAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }
    
    // Traitement pour ChefDepartement
    
    public ChefDepartement addChefDepartement(ChefDepartement employee) {
    	if(isExist(employee))
    		return null;
    	employee.setRole("ChefDepartement");
    	employee.setToken(generateToken());
    	emailService.sendSimpleMail(createEmail(employee));
        return chefDepartementRepository.save(employee);
    }
    

    public ChefDepartement getChefDepartementByID(String id) {
        return chefDepartementRepository.findById(id).orElse(null);
    }

    public ChefDepartement updateChefDepartement(ChefDepartement employee) {
    	ChefDepartement existingEMP = chefDepartementRepository.findById(employee.getLogin()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return  chefDepartementRepository.save(employee);
        }else  {
        	existingEMP.setFirstname(employee.getFirstname());
        	existingEMP.setLastname(employee.getLastname());
        	existingEMP.setEmail(employee.getEmail());
        	existingEMP.setLogin(employee.getLogin());
        	existingEMP.setPassword(employee.getPassword());
        	chefDepartementRepository.save(existingEMP);
        }
        return employee;
    }

    public boolean deleteChefDepartementByID(String id) {
    	ChefDepartement existingEMP = chefDepartementRepository.findById(id).orElse(null);
        if(existingEMP != null) {
        	chefDepartementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ChefDepartement> getAllChefDepartement() {
        return (List<ChefDepartement>) chefDepartementRepository.findAll();
    }
    
    // Traitements pour Agent 
    
    public Agent addAgent(Agent employee) {
    	if(isExist(employee))
    		return null;
    	employee.setRole("Agent");
    	employee.setToken(generateToken());
    	emailService.sendSimpleMail(createEmail(employee));
        return agentRepository.save(employee);
    }

    public Agent getAgentByID(String id) {
        return agentRepository.findById(id).orElse(null);
    }

    public Agent updateAgent(Agent employee) {
    	Agent existingEMP = agentRepository.findById(employee.getLogin()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return  agentRepository.save(employee);
        }else  {
        	existingEMP.setFirstname(employee.getFirstname());
        	existingEMP.setLastname(employee.getLastname());
        	existingEMP.setEmail(employee.getEmail());
        	existingEMP.setLogin(employee.getLogin());
        	existingEMP.setPassword(employee.getPassword());
        	agentRepository.save(existingEMP);
        }
        return employee;
    }

    public boolean deleteAgentByID(String id) {
    	Agent existingEMP = agentRepository.findById(id).orElse(null);
        if(existingEMP != null) {
        	agentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Agent> getAllAgent() {
        return (List<Agent>) agentRepository.findAll();
    }
}

