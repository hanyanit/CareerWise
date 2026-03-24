package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Education;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

class EducationRepositoryTest {

    private IEducationRepository repository;
    private Education education1;
    private Education education2;
    private Education education3;

    @BeforeEach
    void setUp() {
        repository = EducationRepository.getRepository();

        // Clear the repository before each test
        // Since there's no clear method, we need to delete all entries
        List<Education> all = repository.getAll();
        for (Education edu : all) {
            repository.delete(edu.getEducationId());
        }

        // Create test data
        education1 = new Education.Builder()
                .setEducationId("EDU001")
                .setInstitution("UCT")
                .setDegree("Bachelor of Science in Computer Science")
                .setStartDate(LocalDate.of(2012, 1, 25))
                .setEndDate(LocalDate.of(2015, 1, 25))
                .setFieldOfStudy("Computer Science")
                .build();

        education2 = new Education.Builder()
                .setEducationId("EDU002")
                .setInstitution("CPUT")
                .setDegree("DIP: ICT in App Dev")
                .setStartDate(LocalDate.of(2024, 1, 25))
                .setEndDate(LocalDate.of(2026, 12, 25))
                .setFieldOfStudy("Computer Science")
                .build();

        education3 = new Education.Builder()
                .setEducationId("EDU003")
                .setInstitution("UWC")
                .setDegree("Bachelor of Science in Computer Science")
                .setStartDate(LocalDate.of(2022, 1, 25))
                .setEndDate(LocalDate.of(2025, 1, 25))
                .setFieldOfStudy("Computer Science")
                .build();
    }

    @Test
    void create() {
        // Create a new education record
        Education created = repository.create(education1);

        // Verify creation was successful
        assertNotNull(created);
        assertEquals(education1.getEducationId(), created.getEducationId());
        assertEquals(education1.getInstitution(), created.getInstitution());
        assertEquals(education1.getDegree(), created.getDegree());

        // Verify it was added to the repository
        Education found = repository.read(education1.getEducationId());
        assertNotNull(found);
        assertEquals(education1, found);
    }

    @Test
    void read() {
        // First create an education record
        repository.create(education1);

        // Read it back
        Education found = repository.read("EDU001");

        // Verify
        assertNotNull(found);
        assertEquals(education1.getEducationId(), found.getEducationId());
        assertEquals(education1.getInstitution(), found.getInstitution());
        assertEquals(education1.getDegree(), found.getDegree());
    }

    @Test
    void update() {
        // Create an education record
        repository.create(education1);

        // Create updated version with SAME ID
        Education updatedEducation = new Education.Builder()
                .setEducationId("EDU001")  // Keep the same ID
                .setInstitution("University of Johannesburg")
                .setDegree("Bachelor of Science in Architectural Design")
                .setStartDate(LocalDate.of(2025, 1, 25))
                .setEndDate(LocalDate.of(2028, 12, 25))
                .setFieldOfStudy("Engineering")
                .build();

        // Update
        Education result = repository.update(updatedEducation);

        // Verify update was successful
        assertNotNull(result);
        assertEquals("University of Johannesburg", result.getInstitution());
        assertEquals("Bachelor of Science in Architectural Design", result.getDegree());
        assertEquals("Engineering", result.getFieldOfStudy());

        // Verify it was actually updated in the repository
        Education found = repository.read("EDU001");
        assertNotNull(found);
        assertEquals("University of Johannesburg", found.getInstitution());
    }

    @Test
    void delete() {
        // Create an education record
        repository.create(education1);

        // Delete it
        boolean deleted = repository.delete("EDU001");

        // Verify deletion was successful
        assertTrue(deleted);

        // Verify it's no longer in the repository
        Education found = repository.read("EDU001");
        assertNull(found);
    }

    @Test
    void getAll() {
        // Add multiple education records
        repository.create(education1);
        repository.create(education2);
        repository.create(education3);

        // Get all records
        List<Education> allEducations = repository.getAll();

        // Verify
        assertNotNull(allEducations);
        assertEquals(3, allEducations.size());
        assertTrue(allEducations.contains(education1));
        assertTrue(allEducations.contains(education2));
        assertTrue(allEducations.contains(education3));
    }

    @Test
    void findByInstitution() {
        // Add education records
        repository.create(education1); // UCT
        repository.create(education2); // CPUT
        repository.create(education3); // UWC

        // Find by institution
        List<Education> uctEducations = repository.findByInstitution("UCT");
        List<Education> cputEducations = repository.findByInstitution("CPUT");
        List<Education> nonExistentEducations = repository.findByInstitution("NonExistent");

        // Verify UCT results - only education1 is from UCT
        assertNotNull(uctEducations);
        assertEquals(1, uctEducations.size());  // Only one UCT record
        assertTrue(uctEducations.contains(education1));

        // Verify CPUT results
        assertNotNull(cputEducations);
        assertEquals(1, cputEducations.size());
        assertTrue(cputEducations.contains(education2));

        // Verify non-existent institution
        assertNotNull(nonExistentEducations);
        assertEquals(0, nonExistentEducations.size());
    }

    @Test
    void findByDegree() {
        // Add education records
        repository.create(education1); // Bachelor of Science in Computer Science
        repository.create(education2); // DIP: ICT in App Dev
        repository.create(education3); // Bachelor of Science in Computer Science

        // Find by degree
        List<Education> csDegrees = repository.findByDegree("Bachelor of Science in Computer Science");
        List<Education> dipDegrees = repository.findByDegree("DIP: ICT in App Dev");
        List<Education> nonExistentDegrees = repository.findByDegree("Non Existent Degree");

        // Verify - Should find 2 records with this degree (education1 and education3)
        assertNotNull(csDegrees);
        assertEquals(2, csDegrees.size());  // Both education1 and education3
        assertTrue(csDegrees.contains(education1));
        assertTrue(csDegrees.contains(education3));

        // Verify diploma degree
        assertNotNull(dipDegrees);
        assertEquals(1, dipDegrees.size());
        assertTrue(dipDegrees.contains(education2));

        // Verify non-existent degree
        assertNotNull(nonExistentDegrees);
        assertEquals(0, nonExistentDegrees.size());
    }

    @Test
    void findByDegree_CaseInsensitive() {
        repository.create(education1); // Bachelor of Science in Computer Science

        // Search with different case
        List<Education> result = repository.findByDegree("BACHELOR OF SCIENCE IN COMPUTER SCIENCE");

        // Should still find it (using equalsIgnoreCase)
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}