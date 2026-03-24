package za.ac.cput.repository;

import za.ac.cput.domain.Employer;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployerRepository.java
 * Author: Andile Pamela Masina, 221568816
 * Date: 24 March 2026
 */

public class EmployerRepository implements IEmployerRepository {
    private static EmployerRepository repository = null;
    private List<Employer> employerList;

    private EmployerRepository() {
        employerList = new ArrayList<>();
    }

    public static EmployerRepository getRepository() {
        if (repository == null) {
            repository = new EmployerRepository();
        }
        return repository;
    }

    @Override
    public Employer create(Employer employer) {
        boolean success = employerList.add(employer);
        return success ? employer : null;
    }

    @Override
    public Employer read(String companyName) {
        return employerList.stream()
                .filter(e -> e.getCompanyName().equalsIgnoreCase(companyName))
                .findAny()
                .orElse(null);
    }

    @Override
    public Employer update(Employer employer) {
        Employer oldEmployer = read(employer.getCompanyName());
        if (oldEmployer != null) {
            employerList.remove(oldEmployer);
            employerList.add(employer);
            return employer;
        }
        return null;
    }

    @Override
    public boolean delete(String companyName) {
        Employer employerToDelete = read(companyName);
        return employerToDelete != null && employerList.remove(employerToDelete);
    }

    @Override
    public List<Employer> getAll() {
        return employerList;
    }
}