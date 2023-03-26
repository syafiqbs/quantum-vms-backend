package com.oop442.project.service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.User;
import com.oop442.project.entity.VendorAssessmentForm;
import com.oop442.project.error.UserNotFoundException;
import com.oop442.project.error.VendorAssessmentFormNotFoundException;
import com.oop442.project.repository.UserRepository;
import com.oop442.project.repository.VendorAssessmentFormRepository;

@Service
public class VendorAssessmentFormServiceImpl implements VendorAssessmentFormService{

    @Autowired
    private VendorAssessmentFormRepository vendorAssessmentFormRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object createVendorAssessmentForm(String userEmail, Integer deadline) {
        VendorAssessmentForm vendorAssessmentForm = new VendorAssessmentForm();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new UserNotFoundException(userEmail));
        vendorAssessmentForm.setUser(user);

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now().plusDays(deadline);
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        vendorAssessmentForm.setDeadline(date);
        return vendorAssessmentFormRepository.save(vendorAssessmentForm);
    }

    @Override
    public VendorAssessmentForm getVendorAssessmentForm(Long id) {
        return vendorAssessmentFormRepository.findById(id).orElseThrow(() -> new VendorAssessmentFormNotFoundException(id));
    }

    @Override
    public Object getVendorAllAssessmentForms() {
        return vendorAssessmentFormRepository.findAll();
    }

    @Override
    public Object updateVendorAssessmentForm(VendorAssessmentForm vendorAssessmentForm) {
        VendorAssessmentForm vendorAssessmentFormToUpdate = vendorAssessmentFormRepository.findById(vendorAssessmentForm.getId()).orElseThrow(() -> new VendorAssessmentFormNotFoundException(vendorAssessmentForm.getId()));
        Field[] fields = VendorAssessmentForm.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(vendorAssessmentForm) != null) {
                    field.set(vendorAssessmentFormToUpdate, field.get(vendorAssessmentForm));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException("Error while updating Vendor Assessment Form");
            }
        }
        return vendorAssessmentFormRepository.save(vendorAssessmentFormToUpdate);
    }

    @Override
    public Object deleteVendorAssessmentForm(Long id) {
        VendorAssessmentForm vendorAssessmentFormToDelete = vendorAssessmentFormRepository.findById(id).orElseThrow(() -> new VendorAssessmentFormNotFoundException(id));
        vendorAssessmentFormRepository.delete(vendorAssessmentFormToDelete);
        return "VendorAssessmentForm deleted with id: " + id;
    }

    @Override
    public Object approveVendorAssessmentForm(Long id, String status) {
        VendorAssessmentForm vendorAssessmentFormToApprove = vendorAssessmentFormRepository.findById(id).orElseThrow(() -> new VendorAssessmentFormNotFoundException(id));
        vendorAssessmentFormToApprove.setVendorAssessmentResults(status);
        return vendorAssessmentFormRepository.save(vendorAssessmentFormToApprove);
    }

}
