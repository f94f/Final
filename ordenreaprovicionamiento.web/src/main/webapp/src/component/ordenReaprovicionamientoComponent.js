define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/ordenReaprovicionamientoModel', 'controller/ordenReaprovicionamientoController'], function() {
    App.Component.OrdenReaprovicionamientoComponent = App.Component._CRUDComponent.extend({
        name: 'ordenReaprovicionamiento',
        model: App.Model.OrdenReaprovicionamientoModel,
        listModel: App.Model.OrdenReaprovicionamientoList,
        controller : App.Controller.OrdenReaprovicionamientoController
    });
    return App.Component.OrdenReaprovicionamientoComponent;
});