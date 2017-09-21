FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.12.13"

SRCREV = "d8f10c74f4cc06c68a151b4ca426b1477bdb588e"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.12.y \
           file://02-rpi-cm3-dts-64.patch \
"
require linux-raspberrypi.inc

# A LOADADDR is needed when building a uImage format kernel. This value is not
# set by default in rpi-4.8.y and later branches so we need to provide it
# manually. This value unused if KERNEL_IMAGETYPE is not uImage.
KERNEL_EXTRA_ARGS += "LOADADDR=0x00008000"
