package vn.toancauxanh.cms.service;

import com.querydsl.jpa.impl.JPAQuery;

import vn.toancauxanh.gg.model.QThamSo;
//import vn.toancauxanh.gg.model.QThamSo;
import vn.toancauxanh.gg.model.ThamSo;
import vn.toancauxanh.gg.model.enums.ThamSoEnum;
import vn.toancauxanh.service.BasicService;

public class ThamSoService extends BasicService<ThamSo> {
	
	public JPAQuery<ThamSo> getTargetQuery() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA));
		return q.orderBy(QThamSo.thamSo.ngaySua.desc());
	}

	public JPAQuery<ThamSo> getThamSoByKey(ThamSoEnum key) {
		JPAQuery<ThamSo> q = find(ThamSo.class)
				.where(QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA).and(QThamSo.thamSo.ma.eq(key)));
		return q.orderBy(QThamSo.thamSo.ngaySua.desc());
	}

	public ThamSo getTieuDeHoiDap() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(
				QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA).and(QThamSo.thamSo.ma.eq(ThamSoEnum.TIEU_DE_HOI_DAP)));
		ThamSo thamSo = q.fetchFirst();
		if (thamSo == null) {
			thamSo = new ThamSo();
			thamSo.setMa(ThamSoEnum.TIEU_DE_HOI_DAP);

		}
		return thamSo;
	}

	public ThamSo getTieuDeDaiBieu() {
		JPAQuery<ThamSo> q = find(ThamSo.class).where(QThamSo.thamSo.trangThai.ne(core().TT_DA_XOA)
				.and(QThamSo.thamSo.ma.eq(ThamSoEnum.TIEU_DE_DANH_SACH_DAI_BIEU)));
		ThamSo thamSo = q.fetchFirst();
		if (thamSo == null) {
			thamSo = new ThamSo();
			thamSo.setMa(ThamSoEnum.TIEU_DE_DANH_SACH_DAI_BIEU);
		}
		return thamSo;
	}

	// ===================================================================

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
	
}
