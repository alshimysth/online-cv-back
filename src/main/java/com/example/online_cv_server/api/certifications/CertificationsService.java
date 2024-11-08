package com.example.online_cv_server.api.certifications;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Certifications;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CertificationsService {

    private final CertificationsRepository certificationsRepository;

    public CertificationsService(final CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository;
    }

    public List<CertificationsModel> findAll() {
        final List<Certifications> certifications = certificationsRepository.findAll(Sort.by("id"));
        return certifications.stream()
                .map(certification -> mapToModel(certification, new CertificationsModel()))
                .toList();
    }

    public CertificationsModel get(final Integer id) {
        return certificationsRepository.findById(id)
                .map(certifications -> mapToModel(certifications, new CertificationsModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final CertificationsModel certificationsModel) {
        final Certifications certifications = new Certifications();
        mapToEntity(certificationsModel, certifications);
        return certificationsRepository.save(certifications).getId();
    }

    public void update(final Integer id, final CertificationsModel certificationsModel) {
        final Certifications certifications = certificationsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(certificationsModel, certifications);
        certificationsRepository.save(certifications);
    }

    public void delete(final Integer id) {
        certificationsRepository.deleteById(id);
    }

    private CertificationsModel mapToModel(final Certifications certifications,
            final CertificationsModel certificationsModel) {
        certificationsModel.setId(certifications.getId());
        certificationsModel.setCertificationName(certifications.getCertificationName());
        return certificationsModel;
    }

    private CertificationsModel mapToEntity(final CertificationsModel certificationsModel,
            final Certifications certifications) {
        certifications.setCertificationName(certificationsModel.getCertificationName());
        return certificationsModel;
    }

}
