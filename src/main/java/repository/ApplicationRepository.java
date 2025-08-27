package repository;

import java.util.Arrays;

public interface ApplicationRepository {
    Arrays findByStudentId(Long studentId);
}
