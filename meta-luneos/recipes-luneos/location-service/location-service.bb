SUMMARY = "LuneOS Location service"
SECTION = "webos/services"
LICENSE = "GPLv3+ & Apache-2.0"
LIC_FILES_CHKSUM = " \
	file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891 \
	file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
"

inherit webos_ports_ose_repo
inherit webos_cmake
inherit pkgconfig
inherit webos_system_bus
inherit systemd

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

DEPENDS = "luna-service2 glib-2.0 libpbnjson"
RDEPENDS:${PN} = "geoclue"

PV = "0.1.0+git${SRCPV}"
SRCREV = "3e057e050a5a3618884edae10ba765c8aea5d84a"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "org.webosports.service.location.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/files/systemd/org.webosports.service.location.service ${D}${systemd_unitdir}/system/
}
