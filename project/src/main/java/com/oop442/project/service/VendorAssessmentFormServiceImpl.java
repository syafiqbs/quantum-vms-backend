package com.oop442.project.service;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop442.project.entity.VendorAssessmentForm;
import com.oop442.project.error.VendorAssessmentFormNotFoundException;
import com.oop442.project.repository.VendorAssessmentFormRepository;

@Service
public class VendorAssessmentFormServiceImpl implements VendorAssessmentFormService{

    @Autowired
    private VendorAssessmentFormRepository vendorAssessmentFormRepository;

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

    // @Override
    // public Object deleteVendorAssessmentForm(Long id) {
    //     VendorAssessmentForm vendorAssessmentFormToDelete = vendorAssessmentFormRepository.findById(id).orElseThrow(() -> new VendorAssessmentFormNotFoundException(id));
    //     vendorAssessmentFormRepository.delete(vendorAssessmentFormToDelete);
    //     return "VendorAssessmentForm deleted with id: " + id;
    // }

    @Override
    public Object approveVendorAssessmentForm(Long id) {
        VendorAssessmentForm vendorAssessmentFormToApprove = vendorAssessmentFormRepository.findById(id).orElseThrow(() -> new VendorAssessmentFormNotFoundException(id));
        vendorAssessmentFormToApprove.setVendorAssessmentResults("Approved");
        return vendorAssessmentFormRepository.save(vendorAssessmentFormToApprove);
    }

    
    
}
