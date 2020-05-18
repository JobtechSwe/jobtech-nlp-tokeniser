(ns jobtech-nlp-tokeniser.tokeniser
  (:require
   [clojure.string :as str]))




(defn tokenise-no-punctuation [text]
  "Split a text into tokens."
  (-> text
      ;; normalize different types of white space to space
      (str/replace #"\s+" " ")
      ;; Erase punctuation
      (str/replace #"[^\w\s\p{IsAlphabetic}]+" " ") ;; #","
      ;; Split on sequences of space
      (str/split #"\s+")))



(defn create-token [chars]

  )

(defn reducer-fun [acc item]
  (if (= item \space)
    (-> acc
        (update :tokens conj (apply str (:buffer acc)))
        (assoc :buffer [])
        )
    (update acc :buffer conj item)
    )
  )


;; (reduce reducer-fun {:buffer [] :tokens []} short-text)

(def short-text "Räven hoppar över den lata hunden.")



(def some-swedish-text
  "Arbetsförmedlingen är Sveriges största förmedlare av arbeten. Varje år sammanför vi på olika sätt tusentals arbetssökande med arbetsgivare som behöver nya medarbetare. Vi har den samlade kunskapen om arbetsmarknaden, branscher och yrken. Som medarbetare hos oss får du, tillsammans med våra ca 12 000 kreativa och professionella medarbetare, vara med och bidra till att öka sysselsättningen och en välfungerande arbetsmarknad.

  Nu har vi inlett ett viktigt förnyelsearbete mot en modernare myndighet.

  Är du rätt person att hjälpa oss nå dit vi vill?

  Denna tjänst riktar sig främst till dig som blivit uppsagd från Arbetsförmedlingen p.g.a. arbetsbrist och är berättigad till företrädesrätt till återanställning.

  Arbetsförmedlingen genomgår just nu ett intensivt förnyelsearbete. Detta kräver en kraftig utveckling av vår matchningsplattform för att möjliggöra framtagande av digitala tjänster, både inom och utanför Arbetsförmedlingen. Därför söker vi nu en systemutvecklare till Enheten Digital Matchning.

  Viclka är vi

  Teamet som du kommer att jobba i tillhör en enhet som heter JobTech och har sitt främsta fokus på klassificering och klassificeringssystem som taxonomier och ontologier över arbetsmarknaden. Rent konkret jobbar vi med de värden som används i matchningen mellan platsannonser och CV:n som till exempel yrkesbenämningar, kompetensord, förmågor och arbetsuppgifter. Klassificeringssystemen byggs upp manuellt i nära samarbete med en redaktion och maskinellt genom att bearbeta stora mängder text. Vi utvinner bland annat relationer mellan begrepp på arbetsmarknaden med hjälp av teknologier som baserar sig på ordvektorer.

  Vi tillgängliggör klassificeringssystemen externt via REST-API:er med container-baserade micro-tjänster. Vi har stort fokus på att konsumerande system smärtfritt ska kunna följa med i förändringar av värdena i klassificeringssystemen. Vi programmerar främst i Clojure.

  Är du nyfiken på hur vi kodar?

  Allt vi gör är öppen källkod och finns tillgängligt i våra publika git-repon som till exempel: https://github.com/JobtechSwe/jobtech-taxonomy-api

  Kvalifikationer

  - Du har några års erfarenhet av systemutveckling
  - Du kan designa och utveckla robusta och förändringsbara system och komponenter
  - Du kan bearbeta stora datamängder med funktionell programmering
  - Du har grepp om fördelen med immutabilitet i distribuerade system

  Vi ser det som meriterande om du kan: Clojure, Datomic, Datahike, Scala, Python, Datorlingvistik/Textanalys/NLP/NLU/Språkteknologi, Spark, Gensim, Spacy, Maskininlärning med hjälp av till exempel Deep Learning som BiLSTM men även äldre tekniker CRF och HMM, Docker/Kubernetes/OpenShift, Emacs.

  Personliga egenskaper

  Vi söker dig som kan jobba i en platt organisation där du får stora frihetsgrader men där det också ställs höga krav på att kunna ta eget ansvar. Du har en personlig mognad och förmåga att samarbeta och kommunicera med olika sortens personer. Du har också ett driv och engagemang samt är prestigelös och resultatfokuserad. Ett intresse för språk och ord hjälper, men är inget krav.

  Stor vikt kommer att läggas vid dina personliga egenskaper.

  Vad erbjuder vi

  Vår avdelning har ett stort fokus på öppenhet och samhällsnytta så du kommer att bidra till Open source och öppna data. Du har möjlighet att använda en del av din arbetstid varje år till att vidareutbilda dig och kan lära dig den senaste tekniken inom t.ex. maskininlärning via distanskurser på nätet.

  Arbetsförmedlingen erbjuder en attraktiv arbetsplats som utmärks av strävan att vara fri från diskriminering och ge lika möjligheter för alla. Vi välkomnar alla sökande oavsett kön, könsöverskridande identitet eller uttryck, etnicitet, religion, funktionsvariation, sexuell läggning och ålder. Läs mer om vår organisation och vårt uppdrag på vår hemsida http://www.arbetsformedlingen.se.

  Övrigt

  Tjänsten är en tillsvidareanställning och omfattar heltidstjänstgöring. Tillträde snarast eller enligt överenskommelse. Provanställning 6 månader tillämpas om du inte redan är anställd i myndigheten. Placeringsort: Stockholm.

  Arbetsförmedlingen har tagit ställning till rekryteringskanaler och önskar därför inte kontakt med mediesäljare eller rekryteringsföretag gällande förslag på rekryteringslösningar.

  Ansökan

  Klicka på knappen ansök nedan, bifoga personligt brev och CV. Om du har ett publikt Git-repository får du gärna skicka med en länk till detta också. Tjänsten har diarienummer Af-2019/0040 7122. Sista ansökningsdag är den 2019-10-15.

  Vi arbetar aktivt för att vara en myndighet fri från diskriminering. Det är viktigt för oss att all kompetens tas tillvara och vi välkomnar alla sökande. Vi ser positivt på om du har kunskaper i något av våra nationella minoritetsspråk."
  )
