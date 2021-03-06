# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Open webOS Just Type daemon"
SECTION = "webos/base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "libxml2 luna-service2 glib-2.0 json-c sqlite3 "

PV = "2.0.0-1+git${SRCPV}"
SRCREV = "da46ca1ffcbda9e8e04f7949ae3f7b4f04531940"

inherit webos_ports_fork_repo
inherit webos_filesystem_paths
inherit webos_cmake
inherit webos_system_bus
inherit webos_systemd
inherit pkgconfig

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

# TODO: Remove once there's localization support
do_install:append() {
    install -d ${D}${webos_prefix}/universalsearchmgr/resources/en_us
    install -v -m 0644 ${S}/files/UniversalSearchList.json ${D}${webos_prefix}/universalsearchmgr/resources/en_us
}

FILES:${PN} += "${webos_prefix}"
