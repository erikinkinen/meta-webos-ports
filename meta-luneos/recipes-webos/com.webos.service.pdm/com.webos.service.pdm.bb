# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "Physical Device Manager handles physical devices using netlink events"
DESCRIPTION = "Service for detecting and managing physical devices using netlink events. A physical device is a USB device, available internal storage device and so on."
SECTION = "webos/services"
AUTHOR = "Preetham Bhat <preetham.bhat@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

VIRTUAL-RUNTIME_pdm-plugin ?= "pdm-plugin"

DEPENDS = "glib-2.0 luna-service2 libpbnjson pmloglib udev libwebosi18n"
RDEPENDS:${PN} = "fuse-utils gphoto2 gphotofs sdparm gptfdisk-sgdisk e2fsprogs-e2fsck e2fsprogs-tune2fs ntfs-3g ntfs-3g-ntfsprogs dosfstools simple-mtpfs lsof smartmontools util-linux-lsblk"

RDEPENDS:${PN} += "${VIRTUAL-RUNTIME_pdm-plugin}"

PV = "1.0.0-5+git${SRCPV}"
SRCREV = "f9e9c0cf3d10f90ad1df91e770843c2c5cad80a2"

inherit webos_cmake
inherit webos_system_bus
inherit webos_ports_ose_repo
inherit pkgconfig

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}"

# Doesn't build for armv[45]*
COMPATIBLE_MACHINE = "(-)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv6 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "(.*)"
COMPATIBLE_MACHINE:armv7ve = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
