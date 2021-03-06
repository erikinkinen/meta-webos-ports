SUMMARY = "This is the web application launcher for the Luna Next webOS UI platform."
LICENSE = "GPL-3.0 & Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0f93d2cf04b94ac3f04a789a1fb11ead \
    file://COPYING-Apache-2.0;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"

DEPENDS = "qtbase qtdeclarative qtwebengine luna-sysmgr-common libconnman-qt5"
RDEPENDS:${PN} += " \
    qtdeclarative-qmlplugins \
    qtwebengine-qmlplugins \
"

PV = "0.4.1-3+git${SRCPV}"
SRCREV = "b95d031f27eebee0deb7c9660a8080e487738c9b"

SERVICE_NAME = "org.webosports.webappmanager"

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"

S = "${WORKDIR}/git"

inherit pkgconfig
inherit webos_system_bus
inherit webos_ports_repo
inherit webos_cmake_qt5
inherit webos_filesystem_paths
inherit webos_systemd

do_install:append() {
    # Install the additional ACG configuration
    install -v -m 0644 ${S}/files/sysbus/com.palm.luna-apps.role.json ${D}${webos_sysbus_rolesdir}/com.palm.luna-apps.role.json
}

FILES:${PN} += "${webos_frameworksdir}"
