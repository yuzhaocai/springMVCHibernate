package com.class8.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Page<E> implements Iterable<E>,Serializable {

	private static final long serialVersionUID = -4992953222228586557L;
	
	private List<E> result = new ArrayList<E>();
	private Pageable pageable;
	private long total;

	@Override
	public Iterator<E> iterator() {
		return result.iterator();
	}
	
	public Page(List<E> content, Pageable pageable, long total) {

		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}

		this.result.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	public Page(List<E> result) {

		this(result, null, (null == result) ? 0 : result.size());
	}

	public int getNumber() {

		return pageable == null ? 0 : pageable.getPageNumber();
	}

	public int getSize() {

		return pageable == null ? 0 : pageable.getPageSize();
	}

	public int getTotalPages() {

		return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
	}

	public int getNumberOfElements() {

		return result.size();
	}

	public long getTotalElements() {

		return total;
	}

	public boolean hasPreviousPage() {

		return getNumber() > 0;
	}

	public boolean isFirstPage() {

		return !hasPreviousPage();
	}
	
	public boolean hasNextPage() {

		return ((getNumber() + 1) * getSize()) < total;
	}

	public boolean isLastPage() {

		return !hasNextPage();
	}

	public List<E> getContent() {

		return Collections.unmodifiableList(result);
	}

	public boolean hasResult() {

		return !result.isEmpty();
	}
	
}
