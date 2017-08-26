FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.12.9"

SRCREV = "ef79e7bb67c80f0b20a8327692f590a54568eda5"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.12.y \
           file://02-rpi-cm3-dts-64.patch \
"
require linux-raspberrypi.inc

# A LOADADDR is needed when building a uImage format kernel. This value is not
# set by default in rpi-4.8.y and later branches so we need to provide it
# manually. This value unused if KERNEL_IMAGETYPE is not uImage.
KERNEL_EXTRA_ARGS += "LOADADDR=0x00008000"
