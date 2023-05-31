package med.voll.api.domain.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.patient.dto.FindCustom;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Page<Patient> findAllByAtivoTrue(Pageable paginacao);

}
