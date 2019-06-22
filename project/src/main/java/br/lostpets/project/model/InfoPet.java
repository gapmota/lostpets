package br.lostpets.project.model;

import java.util.Date;

public class InfoPet {

	private int animalID;
	private String animalName;
	private Date lostDate;
	private String animalInfos;
	private String animalType;
	private String animalImgPath;
	private String animalSitePath;
	private String ownerName;
	private String ownerEmail;
	private String ownerNumber;
	private String howWasLost;
	private String cepLost;
	
	
	public InfoPet() {}
	
	@SuppressWarnings("deprecation")
	public InfoPet(PetPerdido pet) {
		setAnimalID(pet.getIdAnimal());
		setAnimalName(pet.getNomeAnimal());
		setLostDate(new Date(pet.getDataPerdido()));
		//setAnimalInfos();
		setAnimalType(pet.getTipoAnimal());
		setAnimalImgPath(pet.getPathImg());
		setOwnerEmail(pet.getUsuario().getEmail());
		setOwnerName(pet.getUsuario().getNome());
		setOwnerNumber(pet.getUsuario().getTelefoneCelular());
		setHowWasLost(pet.getDescricao());
		setCepLost(pet.getCep());
	}
	
	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}

	public String getAnimalInfos() {
		return animalInfos;
	}

	public void setAnimalInfos(String animalInfos) {
		this.animalInfos = animalInfos;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalImgPath() {
		return animalImgPath;
	}

	public void setAnimalImgPath(String animalImgPath) {
		this.animalImgPath = animalImgPath;
	}

	public String getAnimalSitePath() {
		return animalSitePath;
	}

	public void setAnimalSitePath(String animalSitePath) {
		this.animalSitePath = animalSitePath;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getHowWasLost() {
		return howWasLost;
	}

	public void setHowWasLost(String howWasLost) {
		this.howWasLost = howWasLost;
	}

	public String getCepLost() {
		return cepLost;
	}

	public void setCepLost(String cepLost) {
		this.cepLost = cepLost;
	}

	@Override
	public String toString() {
		return "InfoPet [animalID=" + animalID + ", animalName=" + animalName + ", lostDate=" + lostDate
				+ ", animalInfos=" + animalInfos + ", animalType=" + animalType + ", animalImgPath=" + animalImgPath
				+ ", animalSitePath=" + animalSitePath + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail
				+ ", ownerNumber=" + ownerNumber + ", ownerNumber=" + ownerNumber + ", howWasLost=" + howWasLost
				+ ", cepLost=" + cepLost + "]";
	}

}
