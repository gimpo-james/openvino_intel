SUMMARY = "Parse strings using a specification based on the Python format() syntax"
HOMEPAGE = "https://github.com/r1chardj0n3s/parse"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ab458ad281b60e6f1b39b3feafbfc05"

SRC_URI[sha256sum] = "9ff82852bcb65d139813e2a5197627a94966245c897796760a3a2a8eb66f020b"

inherit pypi setuptools3 ptest

RDEPENDS:${PN} += "\
    python3-datetime \
    python3-logging \
    python3-numbers \
"

SRC_URI += " \
    file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
    python3-pytest \
"

do_install_ptest() {
    cp -f ${S}/test_parse.py ${D}${PTEST_PATH}/
}
