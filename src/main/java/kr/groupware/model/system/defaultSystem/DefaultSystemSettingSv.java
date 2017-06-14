package kr.groupware.model.system.defaultSystem;

import java.util.List;

public interface DefaultSystemSettingSv {
    List<DefaultSystemSettingData>getDefaultSystemSettings();

    void modifyBrowserTitle(DefaultSystemSettingData defaultSystemSettingData);
}
