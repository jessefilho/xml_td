<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="html" />
    <xsl:template match="/">
        <html>
            <!-- table -->
            <table border="1">
                <tr>
                    <td>Titre</td>
                    <td>Auteur</td>
                    <td>Illustrateur</td>
                    <td>Année</td>
                </tr>
                <!-- display persons -->
                <xsl:apply-templates select="//bd" />
            </table>
        </html>
    </xsl:template>
    <xsl:template match="bd">
        <tr>
            <td>
                <xsl:value-of select="titre" />
            </td>
            <td>
                <xsl:apply-templates select="auteur">
                    <xsl:with-param name="reference">
                        <xsl:value-of select="auteur/@ref" />
                    </xsl:with-param>
                </xsl:apply-templates>
            </td>
            <td>
                <xsl:apply-templates select="illustrateur">
                    <xsl:with-param name="reference">
                        <xsl:value-of select="illustrateur/@ref" />
                    </xsl:with-param>
                </xsl:apply-templates>
            </td>
            <td>
                <xsl:value-of select="sortie" />
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="auteur">
        <xsl:param name="reference" />
        <xsl:value-of select="//personne[@id=$reference]/nom" />
        <xsl:text></xsl:text>
        <xsl:value-of select="//personne[@id=$reference]/prenom" />
    </xsl:template>
    <xsl:template match="illustrateur">
        <xsl:param name="reference" />
        <xsl:value-of select="//personne[@id=$reference]/nom" />
        <xsl:text></xsl:text>
        <xsl:value-of select="//personne[@id=$reference]/prenom" />
    </xsl:template>
</xsl:stylesheet>