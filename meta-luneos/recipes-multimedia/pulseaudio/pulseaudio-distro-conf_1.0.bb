SUMMARY = "Distribution specific configuration for Pulseaudio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
    file://webos-system.pa \
    file://pulseaudio.conf \
"

SRC_URI:append:pinephone = " \
    file://ucm2/PinePhone.conf \
    file://ucm2/HiFi \
    file://ucm2/VoiceCall \
"

do_install() {
    install -d ${D}${sysconfdir}/pulse
    install -m 0644 ${WORKDIR}/webos-system.pa ${D}${sysconfdir}/pulse/

    install -d ${D}${sysconfdir}/default
    install -m 0644 ${WORKDIR}/pulseaudio.conf  ${D}${sysconfdir}/default/pulseaudio.conf
}

do_install:append:pinephone() {
    install -d ${D}${datadir}/alsa/ucm2/PinePhone
    install -m 0644 ${WORKDIR}/ucm2/PinePhone.conf ${D}${datadir}/alsa/ucm2/PinePhone/PinePhone.conf
    install -m 0644 ${WORKDIR}/ucm2/HiFi ${D}${datadir}/alsa/ucm2/PinePhone/HiFi
    install -m 0644 ${WORKDIR}/ucm2/VoiceCall ${D}${datadir}/alsa/ucm2/PinePhone/VoiceCall
}

FILES:${PN} = "${sysconfdir}/pulse ${sysconfdir}/default ${datadir}/alsa/ucm2"
