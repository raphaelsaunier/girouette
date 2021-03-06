(ns girouette.tw.accessibility
  (:require [girouette.tw.common :refer [value-unit->css]]))

(def components
  [{:id :screen-reader
    :rules "
    screen-reader = 'sr-only' | 'not-sr-only'
    "
    :garden (fn [{[type] :component-data}]
              (case type
                "sr-only" {:position "absolute"
                           :width "1px"
                           :height "1px"
                           :padding 0
                           :margin "-1px"
                           :overflow "hidden"
                           :clip "rect(0,0,0,0)"
                           :white-space "nowrap"
                           :border-width 0}
                "not-sr-only" {:position "static"
                               :width "auto"
                               :height "auto"
                               :padding 0
                               :margin 0
                               :overflow "visible"
                               :clip "auto"
                               :white-space "normal"}))}])
