package com.liferay.rest.client.serdes.v1_0;

import com.liferay.rest.client.dto.v1_0.FooVo;
import com.liferay.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author shuai.b.zhang
 * @generated
 */
@Generated("")
public class FooVoSerDes {

	public static FooVo toDTO(String json) {
		FooVoJSONParser fooVoJSONParser = new FooVoJSONParser();

		return fooVoJSONParser.parseToDTO(json);
	}

	public static FooVo[] toDTOs(String json) {
		FooVoJSONParser fooVoJSONParser = new FooVoJSONParser();

		return fooVoJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FooVo fooVo) {
		if (fooVo == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fooVo.getAge() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"age\": ");

			sb.append(fooVo.getAge());
		}

		if (fooVo.getFileEntryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryId\": ");

			sb.append(fooVo.getFileEntryId());
		}

		if (fooVo.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(fooVo.getFileName()));

			sb.append("\"");
		}

		if (fooVo.getFooVoId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fooVoId\": ");

			sb.append(fooVo.getFooVoId());
		}

		if (fooVo.getGender() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append("\"");

			sb.append(_escape(fooVo.getGender()));

			sb.append("\"");
		}

		if (fooVo.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(fooVo.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FooVoJSONParser fooVoJSONParser = new FooVoJSONParser();

		return fooVoJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FooVo fooVo) {
		if (fooVo == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fooVo.getAge() == null) {
			map.put("age", null);
		}
		else {
			map.put("age", String.valueOf(fooVo.getAge()));
		}

		if (fooVo.getFileEntryId() == null) {
			map.put("fileEntryId", null);
		}
		else {
			map.put("fileEntryId", String.valueOf(fooVo.getFileEntryId()));
		}

		if (fooVo.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(fooVo.getFileName()));
		}

		if (fooVo.getFooVoId() == null) {
			map.put("fooVoId", null);
		}
		else {
			map.put("fooVoId", String.valueOf(fooVo.getFooVoId()));
		}

		if (fooVo.getGender() == null) {
			map.put("gender", null);
		}
		else {
			map.put("gender", String.valueOf(fooVo.getGender()));
		}

		if (fooVo.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(fooVo.getName()));
		}

		return map;
	}

	public static class FooVoJSONParser extends BaseJSONParser<FooVo> {

		@Override
		protected FooVo createDTO() {
			return new FooVo();
		}

		@Override
		protected FooVo[] createDTOArray(int size) {
			return new FooVo[size];
		}

		@Override
		protected void setField(
			FooVo fooVo, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "age")) {
				if (jsonParserFieldValue != null) {
					fooVo.setAge(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileEntryId")) {
				if (jsonParserFieldValue != null) {
					fooVo.setFileEntryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					fooVo.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fooVoId")) {
				if (jsonParserFieldValue != null) {
					fooVo.setFooVoId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "gender")) {
				if (jsonParserFieldValue != null) {
					fooVo.setGender((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					fooVo.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}