package lk.lmuthumal.demo.dto;

import lk.lmuthumal.demo.Entity.Company;

public class CompanyDto {
    private int companyId;
    private String name;
    private String email;
    private byte[] logo;
    private String website;

    public CompanyDto() {
    }

    public CompanyDto(String name, String email, byte[] logo, String website) {
        this.setName(name);
        this.setEmail(email);
        this.setLogo(logo);
        this.setWebsite(website);
    }

    public CompanyDto(int companyId, String name, String email, byte[] logo, String website) {
        this.setCompanyId(companyId);
        this.setName(name);
        this.setEmail(email);
        this.setLogo(logo);
        this.setWebsite(website);
    }

    public CompanyDto(Company byId) {
        this.setCompanyId(byId.getCompanyId());
        this.setName(byId.getName());
        this.setEmail(byId.getEmail());
        this.setLogo(byId.getLogo());
        this.setWebsite(byId.getWebsite());
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
