package ru.lisunenko.data_service.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.lisunenko.data.api.StudentDataApi;
import ru.lisunenko.data.model.StudentDataCreateRequest;
import ru.lisunenko.data.model.StudentDataResponse;
import ru.lisunenko.data_service.service.Student;
import ru.lisunenko.data_service.service.StudentRepository;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentDataApi {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<StudentDataResponse> createStudentDataInData(StudentDataCreateRequest request) {
        Student student = new Student();
        student.setName(request.getFullName());
        student.setPassport(request.getPassport());
        studentRepository.save(student);

        StudentDataResponse response = new StudentDataResponse();
        response.setId(student.getId());
        response.setFullName(student.getName());
        response.setPassport(student.getPassport());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<StudentDataResponse> getStudentDataByIdFromData(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return ResponseEntity.notFound().build();

        StudentDataResponse response = new StudentDataResponse();
        response.setId(student.getId());
        response.setFullName(student.getName());
        response.setPassport(student.getPassport());

        return ResponseEntity.ok(response);
    }
}


