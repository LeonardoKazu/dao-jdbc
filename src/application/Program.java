package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        //Executável para teste de SellerDaoJDBC
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        System.out.print("Insira o Id que deseja buscar: ");
        int option = sc.nextInt();
        Seller seller = sellerDao.findById(option);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== TEST 2: seller findByDepartment ===");
        System.out.print("Insira o Id do departament para buscar seus sellers: ");
        option = sc.nextInt();
        Department department = new Department(option, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TEST 4: seller insert ===");
        System.out.print("Nome: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data: (DD/MM/YYYY)");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Salário base: ");
        double baseSalary = sc.nextDouble();
        System.out.print("Insira o Id do departamento que deseja adicionar seu seller: ");
        option = sc.nextInt();
        Seller newSeller = new Seller(null, name, email, birthDate, baseSalary, new Department(option, null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println();

        System.out.println("=== TEST 5: seller update ===");
        /*
        obs: Aqui por enquanto ele apenas troca o nome porém é possivel mudar (name, email, birthDate, baseSalary e department
        através dos metódos modificadores set da classe seller)
         */
        System.out.println("Insira o Id do seller para realizar o update: ");
        seller = sellerDao.findById(sc.nextInt());
        System.out.println("Para qual nome deseja mudar? ");
        sc.nextLine();
        seller.setName(sc.nextLine());
        sellerDao.update(seller);
        System.out.println("Update Completed");
        System.out.println();

        System.out.println("=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        DB.closeConnection();
        sc.close();
    }
}

