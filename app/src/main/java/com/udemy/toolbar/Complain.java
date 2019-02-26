package com.udemy.toolbar;

import java.io.Serializable;

public class Complain implements Serializable
{
    private int complain_id, subject_id, complain_status_id, userID, staff_id, department_id, team_member_id, ward_no,
            is_verified, isAnonymous, complain_source_id;
    private String complainant_name, contact_no, email, complaint_subject, complaint_status, complaint, department_name,
            department_head_name, department_head_contact, member_name, complaint_date, description,
            complain_sourse_text;
    public int getComplain_id() {
        return complain_id;
    }
    public void setComplain_id(int complain_id) {
        this.complain_id = complain_id;
    }
    public int getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
    public int getComplain_status_id() {
        return complain_status_id;
    }
    public void setComplain_status_id(int complain_status_id) {
        this.complain_status_id = complain_status_id;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public int getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    public int getTeam_member_id() {
        return team_member_id;
    }
    public void setTeam_member_id(int team_member_id) {
        this.team_member_id = team_member_id;
    }
    public int getWard_no() {
        return ward_no;
    }
    public void setWard_no(int ward_no) {
        this.ward_no = ward_no;
    }
    public int getIs_verified() {
        return is_verified;
    }
    public void setIs_verified(int is_verified) {
        this.is_verified = is_verified;
    }
    public int getIsAnonymous() {
        return isAnonymous;
    }
    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
    public int getComplain_source_id() {
        return complain_source_id;
    }
    public void setComplain_source_id(int complain_source_id) {
        this.complain_source_id = complain_source_id;
    }
    public String getComplainant_name() {
        return complainant_name;
    }
    public void setComplainant_name(String complainant_name) {
        this.complainant_name = complainant_name;
    }
    public String getContact_no() {
        return contact_no;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getComplaint_subject() {
        return complaint_subject;
    }
    public void setComplaint_subject(String complaint_subject) {
        this.complaint_subject = complaint_subject;
    }
    public String getComplaint_status() {
        return complaint_status;
    }
    public void setComplaint_status(String complaint_status) {
        this.complaint_status = complaint_status;
    }
    public String getComplaint() {
        return complaint;
    }
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    public String getDepartment_head_name() {
        return department_head_name;
    }
    public void setDepartment_head_name(String department_head_name) {
        this.department_head_name = department_head_name;
    }
    public String getDepartment_head_contact() {
        return department_head_contact;
    }
    public void setDepartment_head_contact(String department_head_contact) {
        this.department_head_contact = department_head_contact;
    }
    public String getMember_name() {
        return member_name;
    }
    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
    public String getComplaint_date() {
        return complaint_date;
    }
    public void setComplaint_date(String complaint_date) {
        this.complaint_date = complaint_date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getComplain_sourse_text() {
        return complain_sourse_text;
    }
    public void setComplain_sourse_text(String complain_sourse_text) {
        this.complain_sourse_text = complain_sourse_text;
    }

}
