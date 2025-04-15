package com.example.JMobile.testing.Tests.AndroidVipBrokerBetaTests;

import com.example.JMobile.framework.DataProviders.UserProfile;
import com.example.JMobile.framework.Enums.Categories;
import com.example.JMobile.framework.annotations.*;
import com.example.JMobile.framework.resolver.ActionResolver;
import com.example.JMobile.testing.Watcher;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ScalpProVipTests extends Watcher {

    @Test
    @AllureId("25645")
    @DisplayName("Scalp.Pro. Пользователь статуса Free может добавить индикатор на график")
    @Story(Categories.Story.SCALP_PRO_INDICATOR)
    @Epic(Categories.Epic.VIP_example_BETA)
    @Priority(Categories.Priority.CRITICAL)
    @Platform(Categories.Platform.ANDROID)
    @BusinessDomain(Categories.BusinessDomain.MOBILE)
    @ResponsibleTeam(Categories.ResponsibleTeam.MOBILE)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_VIP_BETA)
    public void AvailableForFreeUserTest() {
        Allure.step("[Precondition]\n" +
                "Пользователь статуса Free\n" +
                "Авторизован в приложении\n" +
                "Открыт трейдрум\n");

        ActionResolver ar = new ActionResolver(mobileDriver, getWelcomePageVip());
        ar.loginWith(UserProfile.VIP_USER);

        ar.step("Переключиться на FTT ассет ZAR/OST");

        ar.step("Открыть селектор индикаторов на вкладке Available", () ->
                ar.step("Открыт селектор индикаторов на вкладке Available"));

        ar.step("Открыть карточку настроек индикатора Scalp pro", () ->
                ar.step("Открыта карточка настроек индикатора Scalp pro")
        );
        ar.step("Нажать на кнопку Apply", () -> {
            ar.step("Карточка настроек индикатора Scalp pro закрыта");
            ar.step("Пользователь в трейдруме");
            ar.step("Под графиком отображается индикатор Scalp pro");
        });
    }

    @Test
    @AllureId("25644")
    @DisplayName("Scalp.Pro. Пользователь статуса VIP может добавить индикатор на график")
    @Story(Categories.Story.SCALP_PRO_INDICATOR)
    @Epic(Categories.Epic.VIP_example_BETA)
    @Priority(Categories.Priority.CRITICAL)
    @Platform(Categories.Platform.ANDROID)
    @BusinessDomain(Categories.BusinessDomain.MOBILE)
    @ResponsibleTeam(Categories.ResponsibleTeam.MOBILE)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_VIP_BETA)
    public void AvailableForVipUserTest() {

        Allure.step("[Precondition]\n" +
                "Пользователь VIP\n" +
                "Авторизован\n" +
                "Открыт Трейдрум");

        ActionResolver ar = new ActionResolver(mobileDriver, getWelcomePageVip());
        ar.loginWith(UserProfile.VIP_USER);

        ar.step("Переключиться на FTT ассет ZAR/OST");

        ar.step("Открыть селектор индикаторов на вкладке Available", () -> {
            ar.step("Открыт селектор индикаторов на вкладке Available");
        });
        ar.step("Открыть карточку настроек индикатора Scalp pro", () -> {
            ar.step("Открыта карточка настроек индикатора Scalp pro");
        });
        ar.step("Нажать на кнопку Apply", () -> {
            ar.step("Карточка настроек индикатора Scalp pro закрыта");
            ar.step("Пользователь в трейдруме");
            ar.step("Под графиком отображается индикатор Scalp pro");
        });
    }

    @Test
    @AllureId("27559")
    @DisplayName("Scalp.Pro. Пользователь статуса Standart не может добавить индикатор на график")
    @Story(Categories.Story.SCALP_PRO_INDICATOR)
    @Epic(Categories.Epic.VIP_example_BETA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_VIP_BETA)
    @Priority(Categories.Priority.CRITICAL)
    @Platform(Categories.Platform.ANDROID)
    @BusinessDomain(Categories.BusinessDomain.MOBILE)
    @ResponsibleTeam(Categories.ResponsibleTeam.MOBILE)
    public void UnavailableForVipUserTest() {
        Allure.step("[Precondition]\n" +
                "Пользователь VIP\n" +
                "Авторизован\n" +
                "Открыт Трейдрум");

        ActionResolver ar = new ActionResolver(mobileDriver, getWelcomePageVip());
        ar.loginWith(UserProfile.DONT_TOUCH_STANDART_USER);

        ar.step("Переключиться на FTT ассет ZAR/OST");

        ar.step("Открыть селектор индикаторов на вкладке Available", () -> {
            ar.step("Открыт селектор индикаторов на вкладке Available");
        });
        ar.step("Нажать на иконку индикатора Scalp pro", () -> {
            ar.step("Карточка настроек индикатора Scalp pro не открылась");
            ar.step("Открылся пэйвол Take a step to get VIP privileges");
        });
    }


    @Test
    @AllureId("24838")
    @DisplayName("Scalp Pro. Изменение настроек. Видимость включена. Проверка в карточке")
    @Story(Categories.Story.SCALP_PRO_INDICATOR)
    @Epic(Categories.Epic.VIP_example_BETA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_VIP_BETA)
    @Priority(Categories.Priority.MEDIUM)
    @Platform(Categories.Platform.ANDROID)
    @BusinessDomain(Categories.BusinessDomain.MOBILE)
    @ResponsibleTeam(Categories.ResponsibleTeam.MOBILE)
    public void ChangingSettingsTest() {
        Allure.step("[Precondition]\n" +
                "Пользователь VIP\n" +
                "Авторизован\n" +
                "Открыт Трейдрум");

        ActionResolver ar = new ActionResolver(mobileDriver, getWelcomePageVip());
        ar.loginWith(UserProfile.VIP_USER);

        ar.step("Переключиться на FTT ассет ZAR/OST");

        ar.step("Открыть селектор индикаторов на вкладке Available", () -> {
            ar.step("Открыт селектор индикаторов на вкладке Available");
        });

        ar.step("Открыть карточку настроек индикатора Scalp pro", () -> {
            ar.step("Открыта карточка настроек индикатора Scalp pro");
        });
        ar.step("Нажать на кнопку Apply", () -> {
            ar.step("Карточка настроек индикатора Scalp pro закрыта");
            ar.step("Пользователь в трейдруме");
            ar.step("Под графиком отображается индикатор Scalp pro");
        });

        ar.step("Тап колесико Scalp Pro", () -> {
            ar.step("Открыта карточка настроек Scalp Pro");
        });
        ar.step("Изменить настройки Fast line");
        ar.step("Изменить настройки Slow line");
        ar.step("Изменить настройки Smoothness");
        ar.step("Тап кнопка Apply");

        ar.step("Тап колесико Scalp Pro", () -> {
            ar.step("Открыта карточка настроек Scalp Pro");
        });
        ar.step("Проверить отображение новых настроек в карточке");
    }

    @Test
    @AllureId("24887")
    @DisplayName("Scalp Pro. Изменение настроек. Видимость отключена. Проверка в карточке")
    @Story(Categories.Story.SCALP_PRO_INDICATOR)
    @Epic(Categories.Epic.VIP_example_BETA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_VIP_BETA)
    @Priority(Categories.Priority.MEDIUM)
    @Platform(Categories.Platform.ANDROID)
    @BusinessDomain(Categories.BusinessDomain.MOBILE)
    @ResponsibleTeam(Categories.ResponsibleTeam.MOBILE)
    public void test() {
        Allure.step("[Precondition]\n" +
                "Пользователь статуса VIP залогинен в приложении.\n" +
                "Механика FTT, открыт трейдрум.\n" +
                "Индикатор Scalp Pro добавлен на график, иконка глазика перечеркнута, видимость индикатора отключена.");

        ActionResolver ar = new ActionResolver(mobileDriver, getWelcomePageVip());
        ar.loginWith(UserProfile.VIP_USER);

        addScalpProAndTurnOff(ar);

        ar.step("Открыть селектор индикаторов", () -> {
            ar.step("Открыт селектор индикаторов");
        });
        ar.step("Открыть карточку настроек индикатора Scalp pro", () -> {
            ar.step("Открыта карточка настроек индикатора Scalp pro");
        });
        ar.step("Изменить настройки Fast line");
        ar.step("Изменить настройки Slow line");
        ar.step("Изменить настройки Smoothness");
        ar.step("Нажать на кнопку Apply", () -> {
            ar.step("Карточка настроек индикатора Scalp pro закрыта");
            ar.step("Пользователь в трейдруме");
        });

        ar.step("Открыть селектор индикаторов", () -> {
            ar.step("Открыт селектор индикаторов");
        });
        ar.step("Снова открыть карточку настроек индикатора Scalp pro", () -> {
            ar.step("Карточка настроек индикатора Scalp pro открыта");
        });
        ar.step("Проверить отображение новых настроек в карточке");
    }

    private void addScalpProAndTurnOff(ActionResolver ar) {
        ar.step("Переключиться на FTT ассет ZAR/OST");

        ar.step("Открыть селектор индикаторов", () -> {
            ar.step("Открыт селектор индикаторов");
        });
        ar.step("Открыть карточку настроек индикатора Scalp pro", () -> {
            ar.step("Карточка настроек индикатора Scalp pro открыта");
        });
        ar.step("Нажать на кнопку Apply", () -> {
            ar.step("Карточка настроек индикатора Scalp pro закрыта");
        });
        ar.step("Открыть селектор индикаторов", () -> {
            ar.step("Открыт селектор индикаторов");
        });
        ar.step("Отключить видимость индикатора кнопкой с иконкой глаза");
        ar.step("Закрыть селектор индикаторов");
    }
}
