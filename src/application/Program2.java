package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        //Executável para teste de DepartmentDaoJDBC
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("Insira o Id do Department que deseja buscar: ");
        int opcao = sc.nextInt();
        Department dep = departmentDao.findById(opcao);
        System.out.println(dep);
        System.out.println();

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }
        System.out.println();

        System.out.println("\n=== TEST 3: insert =======");
        System.out.print("Insira o nome do novo Departament que será adicionado: ");
        sc.nextLine();
        String name = sc.nextLine();
        Department newDepartment = new Department(null, name);
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());
        System.out.println();

        System.out.println("\n=== TEST 4: update =======");
        System.out.print("Insira o Id do Departament que será modificado: ");
        opcao = sc.nextInt();
        Department dep2 = departmentDao.findById(opcao);
        sc.nextLine();
        System.out.print("Insira o novo nome do Department: ");
        name = sc.nextLine();
        dep2.setName(name);
        departmentDao.update(dep2);
        System.out.println("Update completed");
        System.out.println();

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Insira o Id para deletar um Department: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        DB.closeConnection();
        sc.close();
    }
}
