package kr.groupware.model.system.defaultSystem;

import java.util.List;

public interface DefaultSystemSettingRepository {
    List<DefaultSystemSettingData>getDefaultSystemSettings();

    void modifyBrowserTitle(DefaultSystemSettingData defaultSystemSettingData);
}
