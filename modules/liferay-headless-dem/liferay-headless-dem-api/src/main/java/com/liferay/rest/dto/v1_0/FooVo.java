package com.liferay.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
@GraphQLName(description = "the foo vo.", value = "FooVo")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FooVo")
public class FooVo implements Serializable {

	public static FooVo toDTO(String json) {
		return ObjectMapperUtil.readValue(FooVo.class, json);
	}

	@Schema(description = "the age of the entity.")
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@JsonIgnore
	public void setAge(UnsafeSupplier<Long, Exception> ageUnsafeSupplier) {
		try {
			age = ageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the age of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long age;

	@Schema(description = "the file entry id of the entity.")
	public Long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(Long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	@JsonIgnore
	public void setFileEntryId(
		UnsafeSupplier<Long, Exception> fileEntryIdUnsafeSupplier) {

		try {
			fileEntryId = fileEntryIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the file entry id of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileEntryId;

	@Schema(description = "the fileName of the entity.")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@JsonIgnore
	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the fileName of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String fileName;

	@Schema(description = "the foo id of the entity.")
	public Long getFooVoId() {
		return fooVoId;
	}

	public void setFooVoId(Long fooVoId) {
		this.fooVoId = fooVoId;
	}

	@JsonIgnore
	public void setFooVoId(
		UnsafeSupplier<Long, Exception> fooVoIdUnsafeSupplier) {

		try {
			fooVoId = fooVoIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the foo id of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fooVoId;

	@Schema(description = "the gender of the entity.")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public void setGender(
		UnsafeSupplier<String, Exception> genderUnsafeSupplier) {

		try {
			gender = genderUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the gender of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String gender;

	@Schema(description = "the name of the entity.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "the name of the entity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (age != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"age\": ");

			sb.append(age);
		}

		if (fileEntryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryId\": ");

			sb.append(fileEntryId);
		}

		if (fileName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(fileName));

			sb.append("\"");
		}

		if (fooVoId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fooVoId\": ");

			sb.append(fooVoId);
		}

		if (gender != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append("\"");

			sb.append(_escape(gender));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.rest.dto.v1_0.FooVo", name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}