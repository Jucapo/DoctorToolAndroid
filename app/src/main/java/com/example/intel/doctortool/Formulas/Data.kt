package com.example.intel.doctortool.Formulas

import com.example.intel.doctortool.models.Formula

object Data {
    var formulas: MutableList<Formula> = mutableListOf(

            Formula("APACHE II", "Calculo APACHE II", "Cirugia General", "https://image.ibb.co/gM7H2w/a.png"),
            Formula("ASC", "Area Superficie Corporal", "General", "https://image.ibb.co/gM7H2w/a.png"),

            Formula("EDAD G", "Calculo de Edad Gestional", "GinecoObstetricia", "https://image.ibb.co/msxH2w/e.png"),

            Formula("FPP", "Calculo de Fecha Probable de Parto", "GinecoObstetricia", "https://image.ibb.co/nQK89b/f.png"),

            Formula("GUPTA", "Riesgo Cardiaco Preoperatorio", "Anestesiologia", "https://image.ibb.co/cPEKFG/g.png"),

            Formula("HOLLIDAY", "Calculo de Liquidos", "Pediatria", "https://image.ibb.co/gdzKFG/h.png"),

            Formula("IMC", "Indice Masa Corporal", "General", "https://image.ibb.co/mZTDaG/i.png"),

            Formula("LEE", "Indice de pronostico de LEE", "Medicina Interna", "https://image.ibb.co/iV3Phw/l.png"),

            Formula("OSMP", "Osmolaridad Plasmatica", "Anestesiologia", "https://image.ibb.co/hioDaG/o.png"),


            Formula("PAC", "Porcentaje de Agua Corporal", "General", "https://image.ibb.co/kg3eFG/p.png"),
            Formula("PPT", "Percentiles de Peso y Talla", "Pediatria", "https://image.ibb.co/kg3eFG/p.png"),
            Formula("PSE", "Calculo de Peso Segun la Edad", "Pediatria", "https://image.ibb.co/kg3eFG/p.png"),
            Formula("PSP", "Perdidas Sanguineas Permisibles", "Anestesiologia", "https://image.ibb.co/kg3eFG/p.png"),

            Formula("TFG", "Tasa de Filtracion Glomerural", "Medicina Interna", "https://image.ibb.co/dG1o9b/t.png"),

            Formula("VST", "Volumen Total Sanguinio", "General", "https://image.ibb.co/dHn6vG/v.png")
    )
}

object DataGeneral {
    var formulasGe: MutableList<Formula> = mutableListOf(
            Formula("ASC", "Area Superficie Corporal", "General", "https://image.ibb.co/gM7H2w/a.png"),
            Formula("IMC", "Indice Masa Corporal", "General", "https://image.ibb.co/mZTDaG/i.png"),
            Formula("PAC", "Porcentaje de Agua Corporal", "General", "https://image.ibb.co/kg3eFG/p.png"),
            Formula("VST", "Volumen Total Sanguinio", "General", "https://image.ibb.co/dHn6vG/v.png")
    )
}

object DataMedicinaInterna {
    var formulasMe: MutableList<Formula> = mutableListOf(
            Formula("LEE", "Indice de pronostico de LEE", "Medicina Interna", "https://image.ibb.co/iV3Phw/l.png"),
            Formula("TFG", "Tasa de Filtracion Glomerural", "Medicina Interna", "https://image.ibb.co/dG1o9b/t.png")
    )
}

object DataAnestesiologia {
    var formulasAnes: MutableList<Formula> = mutableListOf(
            Formula("OSMP", "Osmolaridad Plasmatica", "Anestesiologia", "https://image.ibb.co/hioDaG/o.png"),
            Formula("PSP", "Perdidas Sanguineas Permisibles", "Anestesiologia", "https://image.ibb.co/kg3eFG/p.png")
            )
}

object DataPediatria {
    var formulasPediatria: MutableList<Formula> = mutableListOf(
            Formula("HOLLIDAY", "Calculo de Liquidos", "Pediatria", "https://image.ibb.co/gdzKFG/h.png"),
            Formula("PPT", "Percentiles de Peso y Talla", "Pediatria", "https://image.ibb.co/kg3eFG/p.png"),
            Formula("PSE", "Calculo de Peso Segun la Edad", "Pediatria", "https://image.ibb.co/kg3eFG/p.png")

            )
}

object DataCirugia {
    var formulasCirugia: MutableList<Formula> = mutableListOf(
            Formula("APACHE II", "Calculo APACHE II", "Cirugia General", "https://image.ibb.co/gM7H2w/a.png")
    )
}

object DataGineco {
    var formulasGineco: MutableList<Formula> = mutableListOf(
            Formula("EDAD G", "Calculo de Edad Gestional", "GinecoObstetricia", "https://image.ibb.co/msxH2w/e.png"),
            Formula("FPP", "Calculo de Fecha Probable de Parto", "GinecoObstetricia", "https://image.ibb.co/nQK89b/f.png")

            )
}

