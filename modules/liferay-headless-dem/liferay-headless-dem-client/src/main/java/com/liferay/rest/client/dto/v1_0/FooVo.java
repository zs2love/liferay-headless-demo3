package com.liferay.rest.client.dto.v1_0;

import com.liferay.rest.client.function.UnsafeSupplier;
import com.liferay.rest.client.serdes.v1_0.FooVoSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
public class FooVo implements Cloneable, Serializable {

	public static FooVo toDTO(String json) {
		return FooVoSerDes.toDTO(json);
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public void setAge(UnsafeSupplier<Long, Exception> ageUnsafeSupplier) {
		try {
			age = ageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long age;

	public Long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(Long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public void setFileEntryId(
		UnsafeSupplier<Long, Exception> fileEntryIdUnsafeSupplier) {

		try {
			fileEntryId = fileEntryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileEntryId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileName;

	public Long getFooVoId() {
		return fooVoId;
	}

	public void setFooVoId(Long fooVoId) {
		this.fooVoId = fooVoId;
	}

	public void setFooVoId(
		UnsafeSupplier<Long, Exception> fooVoIdUnsafeSupplier) {

		try {
			fooVoId = fooVoIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fooVoId;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setGender(
		UnsafeSupplier<String, Exception> genderUnsafeSupplier) {

		try {
			gender = genderUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public FooVo clone() throws CloneNotSupportedException {
		return (FooVo)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FooVo)) {
			return false;
		}

		FooVo fooVo = (FooVo)object;

		return Objects.equals(toString(), fooVo.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FooVoSerDes.toJSON(this);
	}

}