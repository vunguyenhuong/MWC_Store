package customModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.ChatLieu;
import models.ChiTietDep;
import models.Dep;
import models.LoaiDep;
import models.MauSac;
import models.NhaSX;
import models.Size;

/**
 *
 * @author VU NGUYEN HUONG
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CTDepCustom {
    private ChiTietDep ctd;
    private Dep dep;
    private LoaiDep loaiDep;
    private ChatLieu chatLieu;
    private MauSac mauSac;
    private Size size;
    private NhaSX nhaSX;
}
