package vn.toancauxanh.gg.model;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Window;

import com.querydsl.jpa.impl.JPAQuery;

import vn.toancauxanh.gg.model.enums.ThamSoEnum;
import vn.toancauxanh.model.Model;

@Entity
@Table(name = "thamso")
public class ThamSo extends Model<ThamSo> {

	private ThamSoEnum ma;
	private Long value;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Enumerated(EnumType.STRING)
	public ThamSoEnum getMa() {
		return ma;
	}

	public void setMa(ThamSoEnum ma) {
		this.ma = ma;
	}

	// ===============================================

	private String chuDeSelect;

	@Transient
	public String getChuDeSelect() {
		return chuDeSelect;
	}

	public void setChuDeSelect(String chuDeSelect) {
		System.out.println(unAccent(chuDeSelect));
		this.chuDeSelect = chuDeSelect;
	}

	@Command
	public void saveThamSo(@BindingParam("id") String id) throws IOException {

		try {
			if ("capnhatchudetintuc".equals(unAccent(chuDeSelect))) {
				setMa(getChuDeTinTuc().ma);
				setValue(Long.parseLong(id));
				save();
				return;
			} else if ("capnhatchudegioithieu".equals(unAccent(chuDeSelect))) {
				setMa(getChuDeGioiThieu().ma);
				setValue(Long.parseLong(id));
				save();
				return;
			} else if ("capnhatchudelienhe".equals(unAccent(chuDeSelect))) {
				setMa(getChuDeLienHe().ma);
				setValue(Long.parseLong(id));
				save();
				return;
			}
		} catch (NumberFormatException e) {
			showNotification("Bạn chỉ được nhập số", "", "error");
		}
	}

	@Transient
	public ThamSo getChuDeTinTuc() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(
				QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA).and(QThamSo.thamSo.ma.eq(ThamSoEnum.CAT_ID_TINTUC)));
		ThamSo thamSo = q.fetchFirst();
		if (thamSo == null) {
			thamSo = new ThamSo();
			thamSo.setMa(ThamSoEnum.CAT_ID_TINTUC);
		}
		return thamSo;
	}

	@Transient
	public ThamSo getChuDeGioiThieu() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(
				QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA).and(QThamSo.thamSo.ma.eq(ThamSoEnum.CAT_ID_GIOITHIEU)));
		ThamSo thamSo = q.fetchFirst();
		if (thamSo == null) {
			thamSo = new ThamSo();
			thamSo.setMa(ThamSoEnum.CAT_ID_GIOITHIEU);
		}
		return thamSo;
	}

	@Transient
	public ThamSo getChuDeLienHe() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(
				QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA).and(QThamSo.thamSo.ma.eq(ThamSoEnum.CAT_ID_LIENHE)));
		ThamSo thamSo = q.fetchFirst();
		if (thamSo == null) {
			thamSo = new ThamSo();
			thamSo.setMa(ThamSoEnum.CAT_ID_LIENHE);
		}
		return thamSo;
	}
	
//	public void replace(Long id){
//		long temp = 0;
//		List<ThamSo> list = find(ThamSo.class).where(QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA)).fetch();
//		for (ThamSo thamSo : list) {
//			if (thamSo.getId() == id) {
//				temp = id;
//				thamSo.setId(_id);
//			}
//		}
//	}
}
